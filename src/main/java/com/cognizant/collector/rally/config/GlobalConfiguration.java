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

package com.cognizant.collector.rally.config;


import com.cognizant.collector.rally.client.*;
import feign.*;
import feign.auth.*;
import feign.jackson.*;
import feign.okhttp.*;
import feign.slf4j.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cloud.openfeign.support.*;
import org.springframework.context.annotation.*;

import java.util.concurrent.*;

/**
 * GlobalConfiguration
 * @author Cognizant
 */

@Configuration
@Slf4j
public class GlobalConfiguration {

    private static final String AUTHORIZATION = "Authorization";

    @Value("${rallyServer.url}")
    private String rallyServerUrl;
    @Value("${rallyServer.username}")
    private String rallyServerUsername;
    @Value("${rallyServer.password}")
    private String rallyServerPassword;


    @Bean
    public RallyClient rallyClient() {

        return Feign.builder()
                .requestInterceptor(new BasicAuthRequestInterceptor(rallyServerUsername, rallyServerPassword))
                .contract(new SpringMvcContract())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .client(new OkHttpClient())
                .options(new Request.Options(20000, TimeUnit.MILLISECONDS, 20000, TimeUnit.MILLISECONDS, true))
                .logger(new Slf4jLogger(RallyClient.class))
                .logLevel(Logger.Level.FULL)
                .target(RallyClient.class, rallyServerUrl);


    }

}


