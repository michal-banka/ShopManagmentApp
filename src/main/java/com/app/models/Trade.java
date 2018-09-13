package com.app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Trade {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}

/*OneToMany - dwukierunkowość
* połączenie z bazą,
* połączenie z serwerem*/
