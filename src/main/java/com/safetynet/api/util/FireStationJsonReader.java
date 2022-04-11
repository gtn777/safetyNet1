package com.safetynet.api.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.Address;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.safetynet.api.model.FireStation;

import lombok.Data;

@Data
@Service
public class FireStationJsonReader {

	private ObjectMapper objectMapper = new ObjectMapper();

	public Iterable<FireStation> readFireStationsFromJson() throws IOException {

		return null;
	}
}
