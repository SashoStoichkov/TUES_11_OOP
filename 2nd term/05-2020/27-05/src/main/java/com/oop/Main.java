package main.java.com.oop;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) throws InterruptedException, ParseException, IOException {
        ImageClient imageClient = new ImageClient("http://18.184.166.96:3000/api/image");

        System.out.print("Getting image from server...");

        ImageData imageData = imageClient.requestImage();

        printDoneMessage();

        System.out.print("Generating 1d list for all channels...");

        List<Long> redChannel = LongStream.iterate(0, i -> i < imageData.data.size(), i -> i + 4).mapToObj(i -> (Long) imageData.data.get((int) i)).collect(Collectors.toList());
        List<Long> greenChannel = LongStream.iterate(1, i -> i < imageData.data.size(), i -> i + 4).mapToObj(i -> (Long) imageData.data.get((int) i)).collect(Collectors.toList());
        List<Long> blueChannel = LongStream.iterate(2, i -> i < imageData.data.size(), i -> i + 4).mapToObj(i -> (Long) imageData.data.get((int) i)).collect(Collectors.toList());
        List<Long> alphaChannel = LongStream.iterate(3, i -> i < imageData.data.size(), i -> i + 4).mapToObj(i -> (Long) imageData.data.get((int) i)).collect(Collectors.toList());

        printDoneMessage();

        System.out.print("Generating 2d list for all channels...");

        List<List<Long>> oldRedChannel = new ArrayList<>();
        List<List<Long>> oldGreenChannel = new ArrayList<>();
        List<List<Long>> oldBlueChannel = new ArrayList<>();
        List<List<Long>> oldAlphaChannel = new ArrayList<>();

        for (int i = 0; i < imageData.height; i++) {
            List<Long> lineRed = new ArrayList<>();
            List<Long> lineGreen = new ArrayList<>();
            List<Long> lineBlue = new ArrayList<>();
            List<Long> lineAlpha = new ArrayList<>();

            for (int j = 0; j < imageData.width; j++) {
                lineRed.add(redChannel.get((int) ((j * imageData.height) + i)));
                lineGreen.add(greenChannel.get((int) ((j * imageData.height) + i)));
                lineBlue.add(blueChannel.get((int) ((j * imageData.height) + i)));
                lineAlpha.add(alphaChannel.get((int) ((j * imageData.height) + i)));
            }

            oldRedChannel.add(lineRed);
            oldGreenChannel.add(lineGreen);
            oldBlueChannel.add(lineBlue);
            oldAlphaChannel.add(lineAlpha);
        }

        printDoneMessage();

        System.out.println("Enter Values for Mask 3x3:");
        List<List<Long>> mask = generateMask();
        System.out.println("Generating Done!");

        System.out.print("Generating 2d list for all channels with new values...");

        List<List<Long>> newRedChannel = new ArrayList<>();
        List<List<Long>> newGreenChannel = new ArrayList<>();
        List<List<Long>> newBlueChannel = new ArrayList<>();
        List<List<Long>> newAlphaChannel = new ArrayList<>();

        for (int i = 0; i < imageData.height; i++) {
            List<Long> lineRed = new ArrayList<>();
            List<Long> lineGreen = new ArrayList<>();
            List<Long> lineBlue = new ArrayList<>();
            List<Long> lineAlpha = new ArrayList<>();

            for (int j = 0; j < imageData.width; j++) {
                if ((i == 0 || i == (imageData.height - 1)) || (j == 0 || j == (imageData.width - 1))) {
                    lineRed.add(oldRedChannel.get(i).get(j));
                    lineGreen.add(oldGreenChannel.get(i).get(j));
                    lineBlue.add(oldBlueChannel.get(i).get(j));
                    lineAlpha.add(oldAlphaChannel.get(i).get(j));
                } else {
                    lineRed.add(generateNewValue(mask, oldRedChannel, i, j));
                    lineGreen.add(generateNewValue(mask, oldGreenChannel, i, j));
                    lineBlue.add(generateNewValue(mask, oldBlueChannel, i, j));
                    lineAlpha.add(generateNewValue(mask, oldAlphaChannel, i, j));
                }
            }

            newRedChannel.add(lineRed);
            newGreenChannel.add(lineGreen);
            newBlueChannel.add(lineBlue);
            newAlphaChannel.add(lineAlpha);
        }

        printDoneMessage();

        System.out.print("Generating 1d list for all channels...");

        List<Long> newRedChannelList = generateNewChannelList(newRedChannel, imageData.height, imageData.width);
        List<Long> newGreenChannelList = generateNewChannelList(newGreenChannel, imageData.height, imageData.width);
        List<Long> newBlueChannelList = generateNewChannelList(newBlueChannel, imageData.height, imageData.width);
        List<Long> newAlphaChannelList = generateNewChannelList(newAlphaChannel, imageData.height, imageData.width);

        printDoneMessage();

        System.out.print("Generating 1d data for sharpened image...");

        List<Long> newImageData = new ArrayList<>();
        for (int i = 0; i < imageData.height * imageData.width;) {
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0 -> newImageData.add(newRedChannelList.get(i++));
                    case 1 -> newImageData.add(newGreenChannelList.get(i++));
                    case 2 -> newImageData.add(newBlueChannelList.get(i++));
                    case 3 -> newImageData.add(newAlphaChannelList.get(i++));
                }
            }
        }

        printDoneMessage();

        System.out.print("Generating new image and sending back to the server...");

        ImageData newImage = new ImageData(imageData.width, imageData.height, newImageData, imageData.name);
        imageClient.sendImage(newImage);

        System.out.println(" Image sent successfully :)");
    }

    public static void printDoneMessage() {
        System.out.println(" Done!");
        System.out.println("======================================");
    }

    public static List<Long> generateNewChannelList(List<List<Long>> channelValues, long height, long width) {
        List<Long> channel = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                channel.add(channelValues.get(i).get(j));
            }
        }

        return channel;
    }

    public static Long generateNewValue(List<List<Long>> mask, List<List<Long>> channelValues, Integer iIndex, Integer jIndex) {
        Long newValue = channelValues.get(iIndex).get(jIndex);

        // TopLine Elements ===========================================================
        // TopLeft Element
        newValue += channelValues.get(iIndex-1).get(jIndex-1) * mask.get(0).get(0);

        // TopMiddle Element
        newValue += channelValues.get(iIndex-1).get(jIndex) * mask.get(0).get(1);

        // TopRight Element
        newValue += channelValues.get(iIndex-1).get(jIndex+1) * mask.get(0).get(2);

        // MiddleLine Elements ===========================================================
        // Left Element
        newValue += channelValues.get(iIndex).get(jIndex-1) * mask.get(1).get(0);

        // Middle Element
        newValue += channelValues.get(iIndex).get(jIndex) * mask.get(1).get(1);

        // Right Element
        newValue += channelValues.get(iIndex).get(jIndex+1) * mask.get(1).get(2);

        // BottomLine Elements ===========================================================
        // BottomLeft Element
        newValue += channelValues.get(iIndex+1).get(jIndex-1) * mask.get(2).get(0);

        // BottomMiddle Element
        newValue += channelValues.get(iIndex+1).get(jIndex) * mask.get(2).get(1);

        // BottomRight Element
        newValue += channelValues.get(iIndex+1).get(jIndex+1) * mask.get(2).get(2);

        return newValue;
    }

    public static List<List<Long>> generateMask() {
        List<List<Long>> mask = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        List<Long> maskLine1 = new ArrayList<>();
        maskLine1.add(scanner.nextLong());
        maskLine1.add(scanner.nextLong());
        maskLine1.add(scanner.nextLong());
        mask.add(maskLine1);

        List<Long> maskLine2 = new ArrayList<>();
        maskLine2.add(scanner.nextLong());
        maskLine2.add(scanner.nextLong());
        maskLine2.add(scanner.nextLong());
        mask.add(maskLine2);

        List<Long> maskLine3 = new ArrayList<>();
        maskLine3.add(scanner.nextLong());
        maskLine3.add(scanner.nextLong());
        maskLine3.add(scanner.nextLong());
        mask.add(maskLine3);

        return mask;
    }
}
