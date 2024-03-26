package com.spotlight.nandhini.service;

import com.spotlight.nandhini.dto.Request.EventRequest;
import com.spotlight.nandhini.dto.Response.BasicResponse;
import com.spotlight.nandhini.model.Event;

public interface EventService {

	BasicResponse<String> postEvent(EventRequest eventRequest);

    BasicResponse<Event> updateEvent(EventRequest eventRequest);

    BasicResponse<Event> getEvents();

    BasicResponse<String> deleteEvent(EventRequest eventRequest);

    


    
}
