package com.itplace.volshin.homework8.service;

import com.itplace.volshin.homework8.service.api.StringListService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StringListServiceImp implements StringListService {

    @Override
    public List<String> stringToList(String string) {
        if (string.isEmpty())
            return null;
        List<String> list = Arrays.asList(string.split("\",\""));
        if (list.size() == 1)
            return list;
        final String firstElement = list.get(0);
        list.set(0, firstElement.substring(1, firstElement.length()));
        final String endElement = list.get(list.size() - 1);
        list.set(list.size() - 1, endElement.substring(0, endElement.length() - 1));
        return list;
    }

}
