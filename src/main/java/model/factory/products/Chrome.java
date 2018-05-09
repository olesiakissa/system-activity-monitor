package model.factory.products;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Chrome implements Browser {

    @NotBlank
    private String name;

    @NotBlank
    private String version;

}
