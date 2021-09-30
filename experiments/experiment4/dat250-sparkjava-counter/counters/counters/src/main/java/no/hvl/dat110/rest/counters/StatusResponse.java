package no.hvl.dat110.rest.counters;

public enum StatusResponse {
    SUCCESS("Success"),
    ERROR("Error");

    final private String status;

    StatusResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}