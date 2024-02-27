# Invoice Management System Documentation
This system is designed to perform various operations on customers, invoices, and companies. The system includes the management classes CustomerManager and InvoiceManager, as well as the fundamental entity classes Customer, Invoice, Company.
## Entity Classes
### Customer
Represents customers. It includes the name, registration date, and other relevant information for each customer.
* Attributes: name, registrationDate, etc.
### Invoice
Represents invoices. It includes the total amount, date, and customer information for each invoice.
* Attributes: totalAmount, date, customer, etc.
### Company
Represents companies. It includes the name, sector, and a list of invoices for each company.
* Attributes: name, sector, invoices, etc.
Yönetim Sınıfları ve Metotları
CustomerManager
Müşteri ile ilgili işlemleri yönetir.

### Management Classes and Methods

#### CustomerManager
Manages operations related to customers.

* Methods
    * addCustomer(Customer customer): Adds a new customer.
    * listAllCustomers(): Lists all customers in the system.
    * listCustomersWithLetter(char letter): Lists customers whose names start with a specific letter.
* InvoiceManager
Manages operations related to invoices and companies.

* Methods
    * addInvoices(List<Invoice> invoices): Adds new invoices.
    * addCompanies(List<Company> companies): Adds new companies.
    * getTotalAmountForCustomersRegisteredInAMonth(Month month): Calculates the total amount of invoices for customers registered in a specific month.
    * listAllInvoices(): Lists all invoices in the system.
    * listInvoicesOverAmount(double amount): Lists invoices over a specific amount.
    * averageOfInvoicesOverAmount(double amount): Calculates the average amount of invoices over a specific amount.
    * nameOfCustomersWithInvoicesUnderAmount(double amount): Lists the names of customers with invoices under a specific amount.
    * sectorOfCompaniesWithAverageInvoiceUnderAmountInMonth(double amount, Month month): Lists the sectors of companies with an average invoice amount under a specific amount in a specific month.