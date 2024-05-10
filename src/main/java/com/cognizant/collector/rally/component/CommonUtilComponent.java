/*
 *  © [2021] Cognizant. All rights reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.cognizant.collector.rally.component;

import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

import static com.cognizant.collector.rally.constants.Constant.*;

/**
 * CommonUtilComponent
 * @author Cognizant
 */

@Component
@Slf4j
public class CommonUtilComponent {

    static String rallyCollectionName;

    public static String getRallyCollectionName() {
        return rallyCollectionName;
    }

    @Value("${spring.data.mongodb.collection}")
    public void setRallyCollectionName(String rallyCollectionName) {
        CommonUtilComponent.rallyCollectionName = SOURCE+rallyCollectionName;
    }

    public String parseDateToString(Date date) {
        if (null == date) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    public Date getDateFromString(String dateString) {
        Date date = null;
        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);
            date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        } catch (DateTimeParseException e) {
            log.info("Return value as null, due to exception while parsing string to date, Exception:{}");
        }
        return date;
    }

    public Integer getIntegerFromString(String integerString) {
        Integer integer = null;
        try {
            integer = Integer.valueOf(integerString);
        } catch (NumberFormatException e) {
            log.info("Return value as null, due to exception while parsing string to integer, Exception:{}");
        }
        return integer;
    }

    public Map<String, String> getMap(String input) {
        Map<String, String> map = new HashMap<>();
        if (!(input.contains("[") && input.contains("]"))) return map;

        String[] strings = input.substring(input.indexOf('[') + 1, input.indexOf(']')).split(",");
        List<String> list = Arrays.asList(strings);
        list.forEach(s -> {
            String[] split = s.split("=");
            String key = split[0];
            if (split.length == 2) {
                String value = split[1].equals("<null>") ? null : split[1];
                map.put(key, value);
            }
        });

        return map;
    }

}
