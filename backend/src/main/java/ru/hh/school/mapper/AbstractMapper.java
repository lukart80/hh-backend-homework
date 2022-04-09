package ru.hh.school.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.ServerErrorException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class AbstractMapper {

    protected final ObjectMapper mapper = new ObjectMapper();

    protected <E> List<E> mapItemList(String apiResponse, Class<E> clz) {
        try {
            JsonNode items = mapper.readTree(apiResponse).get("items");

            return StreamSupport.stream(items.spliterator(), false)
                    .map(item -> mapNodeToDto(item, clz))
                    .collect(Collectors.toList());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(500);
        }

    }

    private <E> E mapNodeToDto(JsonNode node, Class<E> clz) {
        try {
            return mapper.treeToValue(node, clz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(500);
        }
    }

    protected <E> E mapItem(String apiResponse, Class<E> clz) {
        try {
            JsonNode item = mapper.readTree(apiResponse);
            return mapNodeToDto(item, clz);
        } catch (JsonProcessingException e ) {
            e.printStackTrace();
            throw new ServerErrorException(500);
        }
    }


}
