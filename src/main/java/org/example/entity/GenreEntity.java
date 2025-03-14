package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GenreEntity {
    private UUID id;
    private String nameUz;
    private String nameEng;
    private String nameRu;

    public GenreEntity(String nameUz, String nameEng, String nameRu) {
        this.nameUz = nameUz;
        this.nameEng = nameEng;
        this.nameRu = nameRu;
        this.id = UUID.randomUUID();
    }


}
