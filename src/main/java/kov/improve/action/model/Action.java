package kov.improve.action.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "actions")
@Data
@NoArgsConstructor
@EqualsAndHashCode( exclude = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Action {

    @Id
    @Column(name = "actionId")
    @GeneratedValue
    @NotNull
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "amount")
    @NotNull
    private int amount;


}