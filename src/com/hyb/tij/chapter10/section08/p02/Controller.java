package com.hyb.tij.chapter10.section08.p02;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller {
	private List<Event> eventList = new ArrayList<>();
	
	private static final Logger LOG = LoggerFactory.getLogger(Controller.class);
	
	public void addEvent(Event c) {
		eventList.add(c);
	}

	public void run() {
		while (eventList.size() > 0) {
			//遍历数组的时候如果操作修改了数组的长度，将会导致遍历结果出现问题，这里的做法是用数组的备份进行遍历，实际操作的时候，操作数组
			for (Event e : new ArrayList<Event>(eventList)) {
				if (e.ready()) {
					LOG.info(e.toString());
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
}
