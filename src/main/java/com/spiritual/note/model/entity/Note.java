package com.spiritual.note.model.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Notes")
@Getter @Setter @NoArgsConstructor
public class Note {

    @Id
    @Column(name = "note_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int note_id;
    @Column(name = "nDate")
    private String nDate;
    @Column(name = "sala")
    private String sala;
    @Column(name = "soom")
    private String soom;
    @Column(name="tillWhat")
    private String tillWhat;
    @Column(name="sfrName")
    private String sfrName;
    @Column(name = "es7a7Num")
    private String es7a7Num;
    @Column(name="aya")
    private String aya;
    @Column(name = "odas")
    private String odas;
    @Column(name = "degree")
    private int degree;

    @Column(name = "user_id")
    @NotNull
    private int user_id;

}
