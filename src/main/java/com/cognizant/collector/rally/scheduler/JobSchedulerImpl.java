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

package com.cognizant.collector.rally.scheduler;

import com.cognizant.collector.rally.component.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
/**
 * JobSchedulerImpl
 * @author Cognizant
 */

@Component
@Slf4j
public class JobSchedulerImpl implements BatchEvents {
    @Autowired
    private RallyComponent component;

    @Override
    public void beforeJob() {
        log.info("Before Job process........!");
        component.getRallyDetails();
    }

    @Override
    public void beforeTask() {
        log.info("Before Task process........!");
    }

    @Override
    public void afterTask() {
        log.info("After Task process........!");
    }

    @Override
    public void afterJob() {
        log.info("After Job process........!");
    }
}