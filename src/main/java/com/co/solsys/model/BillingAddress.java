package com.co.solsys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "billing")
public class BillingAddress {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JsonIgnore
    @ApiModelProperty(hidden = true , readOnly = true )
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;

    private String address1;
    private String address2;
    private String postalCode;
    private String providence;

    @JsonIgnore
    @ApiModelProperty(hidden = true  )
    @OneToOne(mappedBy = "billingAddress")
    private Account account;
}
