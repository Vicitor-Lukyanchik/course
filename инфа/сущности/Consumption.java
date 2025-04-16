package com.example.custom.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder=true)
@Table(name = "consumption")
public class Consumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "storehouse_id")
    private Long storehouseId;


    @Column(name = "storehouse_number")
    private String storehouseNumber;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "turnover_count")
    private Double turnoverCount;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_id")
    private Currency currency;


    @Column(name = "external_receiver_code")
    private Integer externalReceiverCode;

    @Column(name = "external_receiver_name")
    private String externalReceiverName;


    @Column(name = "document_type")
    private Integer documentType;

    @Column(name = "document_number")
    private Integer documentNumber;

    @Column(name = "reporting_month")
    private Integer reportingMonth;

    @Column(name = "reporting_year")
    private Integer reportingYear;


    @Column(name = "accompanying_document_number")
    private String accompanyingDocumentNumber;

    @Column(name = "accompanying_document_series")
    private String accompanyingDocumentSeries;

    @Column(name = "accompanying_document_date")
    private LocalDate accompanyingDocumentDate;


    @Column(name = "nom_f")
    private String nom_f;

    @Column(name = "dat_f")
    private LocalDate dat_f;



    @Column(name = "workshop_receiver")
    private String workshopReceiver;

    @Column(name = "application_number")
    private String applicationNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arrival_id")
    private Arrival arrival;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consumption)) return false;
        Consumption that = (Consumption) o;
        return Objects.equals(getUnit().getUnitName(), that.getUnit().getUnitName()) && Objects.equals(getStorehouseNumber(), that.getStorehouseNumber()) && Objects.equals(getProductName(), that.getProductName()) && Objects.equals(getTurnoverCount(), that.getTurnoverCount()) && Objects.equals(getProductPrice(), that.getProductPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStorehouseNumber(), getProductName(), getTurnoverCount(), getProductPrice());
    }
}
