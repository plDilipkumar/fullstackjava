package com.example.invoicex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.invoicex.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
