package com.winit.cloudlink.rabbitmq.loader;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.winit.cloudlink.rabbitmq.mgmt.model.ProducedByRabbit;
import com.winit.cloudlink.rabbitmq.mgmt.model.Queue;

import java.lang.annotation.Annotation;

/**
 * @author Richard Clayton (Berico Technologies)
 */
public class GsonFieldExclusionStrategy implements ExclusionStrategy {

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {

        if (fieldAttributes.getDeclaringClass().equals(Queue.class)){

            return isProducedByRabbit(fieldAttributes);
        }
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }

    private boolean isProducedByRabbit(FieldAttributes attributes){

        for (Annotation annotation : attributes.getAnnotations()){

            if (annotation.annotationType().equals(ProducedByRabbit.class)){

                return true;
            }
        }

        return false;
    }
}
