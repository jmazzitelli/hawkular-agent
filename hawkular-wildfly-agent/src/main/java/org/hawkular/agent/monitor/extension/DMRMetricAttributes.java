/*
 * Copyright 2015-2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.agent.monitor.extension;

import java.util.concurrent.TimeUnit;

import org.jboss.as.controller.AttributeDefinition;
import org.jboss.as.controller.SimpleAttributeDefinition;
import org.jboss.as.controller.SimpleAttributeDefinitionBuilder;
import org.jboss.as.controller.operations.validation.TimeUnitValidator;
import org.jboss.as.controller.registry.AttributeAccess;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.ModelType;

public interface DMRMetricAttributes {

    SimpleAttributeDefinition PATH = new SimpleAttributeDefinitionBuilder("path",
            ModelType.STRING)
            .setAllowNull(false)
            .setAllowExpression(true)
            .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
            .build();

    SimpleAttributeDefinition ATTRIBUTE = new SimpleAttributeDefinitionBuilder("attribute",
            ModelType.STRING)
            .setAllowNull(false)
            .setAllowExpression(true)
            .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
            .build();

    SimpleAttributeDefinition RESOLVE_EXPRESSIONS = new SimpleAttributeDefinitionBuilder("resolveExpressions",
            ModelType.BOOLEAN)
                    .setAllowNull(true)
                    .setDefaultValue(new ModelNode(false))
                    .setAllowExpression(true)
                    .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
                    .build();

    SimpleAttributeDefinition INCLUDE_DEFAULTS = new SimpleAttributeDefinitionBuilder("includeDefaults",
            ModelType.BOOLEAN)
                    .setAllowNull(true)
                    .setDefaultValue(new ModelNode(true))
                    .setAllowExpression(true)
                    .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
                    .build();

    SimpleAttributeDefinition INTERVAL = new SimpleAttributeDefinitionBuilder("interval",
            ModelType.INT)
            .setAllowNull(true)
            .setDefaultValue(new ModelNode(5))
            .setAllowExpression(true)
            .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
            .build();

    SimpleAttributeDefinition TIME_UNITS = new SimpleAttributeDefinitionBuilder("timeUnits",
            ModelType.STRING)
            .setAllowNull(true)
            .setDefaultValue(new ModelNode(TimeUnit.MINUTES.name()))
            .setAllowExpression(true)
            .setValidator(new TimeUnitValidator(true, true, TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES))
            .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
            .build();

    SimpleAttributeDefinition METRIC_UNITS = new SimpleAttributeDefinitionBuilder("metricUnits",
            ModelType.STRING)
            .setAllowNull(true)
            .setAllowExpression(true)
            .setValidator(MeasurementUnitValidator.ANY_OPTIONAL)
            .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
            .build();

    SimpleAttributeDefinition METRIC_TYPE = new SimpleAttributeDefinitionBuilder("metricType",
            ModelType.STRING)
            .setAllowNull(true)
            .setAllowExpression(true)
            .setValidator(MetricTypeValidator.ANY_OPTIONAL)
            .addFlag(AttributeAccess.Flag.RESTART_RESOURCE_SERVICES)
            .build();

    AttributeDefinition[] ATTRIBUTES = {
            PATH,
            ATTRIBUTE,
            RESOLVE_EXPRESSIONS,
            INCLUDE_DEFAULTS,
            METRIC_TYPE,
            INTERVAL,
            TIME_UNITS,
            METRIC_UNITS
    };
}
