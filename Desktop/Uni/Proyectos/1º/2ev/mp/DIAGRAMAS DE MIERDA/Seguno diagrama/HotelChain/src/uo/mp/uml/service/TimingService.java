package uo.mp.uml.service;

import uo.mp.uml.service.timing.Tick;

public class TimingService {
	
	void tick() {
		new Tick().execute();
	}

}
