package kov.improve.action.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table (name = "gifts")
@Data
@NoArgsConstructor
@EqualsAndHashCode( exclude = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Gift {

    @Id
    @Column(name = "giftId")
    @GeneratedValue
    @NotNull
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "quantity")
    @NotNull
    private int quantity;

}
