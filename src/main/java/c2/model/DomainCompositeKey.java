package c2.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class DomainCompositeKey implements Serializable {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Integer idType;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomainCompositeKey that = (DomainCompositeKey) o;

        if (!id.equals(that.getId())) return false;

        return idType.equals(that.getIdType());
    }

    @Override
    public int hashCode() {

        int result = id.hashCode();
        result = 31 * result + idType.hashCode();

        return result;
    }
}
