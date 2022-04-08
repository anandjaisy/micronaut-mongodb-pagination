package fete.bird.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.MappedEntity;
import org.bson.types.ObjectId;
import io.micronaut.data.annotation.Id;

@MappedEntity
public record Discount(
        @Id
        @GeneratedValue
        ObjectId Id,
        String DiscountCode) {
}
