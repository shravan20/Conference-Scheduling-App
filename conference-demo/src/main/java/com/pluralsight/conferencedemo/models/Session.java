package com.pluralsight.conferencedemo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity(name = "sessions") // :Specifies that the class is an entity. This annotation is applied to the entity class.
@Table(name = "sessions") // :Specifies the primary table for the annotated entity. Additional tables may be specified using SecondaryTable or SecondaryTables annotation. If no Table annotation is specified for an entity class, the default values apply.
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;

    private String session_name;

    private String session_description;

    private Integer session_length;

    @ManyToMany
    @JoinTable(
            name="session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers;


}
