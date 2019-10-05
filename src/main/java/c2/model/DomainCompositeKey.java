package c2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class DomainCompositeKey implements Serializable {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String idType;

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
