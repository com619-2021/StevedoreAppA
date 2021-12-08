package uk.ac.solent.devops.model.order.dto;

import uk.ac.solent.devops.model.party.dto.Party;
import uk.ac.solent.devops.model.utilities.OrderToJsonConverter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class OrderChangeRequestEntity {

    // NOTE NOT ORDER ENTITY - THIS IS EMBEDDED
    private Order changeRequest;

    private Date requestDate;

    private Date approvedDate;

    private ChangeStatus status;

    private String changeReason;

    private Party changeRequestor;

    private String responseDescription;

    private Long id;

    private String uuid;

    private String href;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // this avoids having to create tables for the recieved change request
    // but at the expense of not being able to search on characterists 
    @Column(name = "orderchange", length = 1000)
    @Convert(converter = OrderToJsonConverter.class)
    public Order getChangeRequest() {
        return changeRequest;
    }

    public void setChangeRequest(Order changeRequest) {
        this.changeRequest = changeRequest;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public ChangeStatus getStatus() {
        return status;
    }

    public void setStatus(ChangeStatus status) {
        this.status = status;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    @OneToOne
    public Party getChangeRequestor() {
        return changeRequestor;
    }

    public void setChangeRequestor(Party changeRequestor) {
        this.changeRequestor = changeRequestor;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "OrderChangeRequestEntity{" + "requestDate=" + requestDate + ", approvedDate=" + approvedDate + ", status=" + status + ", changeReason=" + changeReason + ", changeRequestor=" + changeRequestor + ", responseDescription=" + responseDescription + ", id=" + id + ", uuid=" + uuid + ", href=" + href + '}';
    }

}
