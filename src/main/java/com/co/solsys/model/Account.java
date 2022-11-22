package com.co.solsys.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private Double balance;
    @Size(max = 1)
    private String status;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "billingAddress_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private BillingAddress billingAddress;
}