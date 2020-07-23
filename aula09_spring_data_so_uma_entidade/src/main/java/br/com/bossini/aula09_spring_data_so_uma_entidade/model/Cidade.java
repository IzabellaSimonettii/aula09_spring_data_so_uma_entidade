package br.com.bossini.aula09_spring_data_so_uma_entidade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cidade {

//    Atividade - 1. Crie um novo projeto para manipular objetos do tipo “Cidade”,
//    os quais têm nome, latitude, longitude e id.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String latitude;
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade)) return false;
        Cidade cidade = (Cidade) o;
        return getId().equals(cidade.getId()) &&
                getNome().equals(cidade.getNome()) &&
                getLatitude().equals(cidade.getLatitude()) &&
                getLongitude().equals(cidade.getLongitude());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getLatitude(), getLongitude());
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
