zoo: main.o mammal.o animal.o fish.o bird.o can_walk.o can_swim.o can_fly.o lion.o whale.o salmon.o flying_fish.o seagull.o ostrich.o
	g++ -o zoo main.o mammal.o animal.o fish.o bird.o can_walk.o can_swim.o can_fly.o lion.o whale.o salmon.o flying_fish.o seagull.o ostrich.o

main.o : main.cpp
	g++ -c main.cpp

animal.o : animal.cpp animal.h
	g++ -c animal.cpp

mammal.o : mammal.cpp mammal.h
	g++ -c mammal.cpp

fish.o : fish.cpp fish.h
	g++ -c fish.cpp

bird.o : bird.cpp bird.h
	g++ -c bird.cpp

can_walk.o : can_walk.cpp can_walk.h
	g++ -c can_walk.cpp

can_swim.o : can_swim.cpp can_swim.h
	g++ -c can_swim.cpp

can_fly.o : can_fly.cpp can_fly.h
	g++ -c can_fly.cpp

lion.o : lion.cpp lion.h
	g++ -c lion.cpp

whale.o : whale.cpp whale.h
	g++ -c whale.cpp

salmon.o : salmon.cpp salmon.h
	g++ -c salmon.cpp

flying_fish.o : flying_fish.cpp flying_fish.h
	g++ -c flying_fish.cpp

seagull.o : seagull.cpp seagull.h
	g++ -c seagull.cpp

ostrich.o : ostrich.cpp ostrich.h
	g++ -c ostrich.cpp

clean:
	rm -rf *.o zoo