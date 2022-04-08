package fete.bird.specification;

import fete.bird.entity.Discount;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification;

@Introspected
public record Specifications() {
    public static PredicateSpecification<Discount> discountCodeEquals(String discountCode) {
        return (root, criteriaBuilder) -> criteriaBuilder.equal(root.get("DiscountCode"), discountCode);
    }
}
