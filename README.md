**Receipt Processor**
**Features**
1) Submit receipts for processing.

2) Retrieve points awarded for a given receipt.

**Tech Stack**
Java (Spring Boot)
Maven for dependency management
Docker for containerization

**Endpoints**
1. Process a Receipt

```
POST /receipts/process
```
3. Get Points for a Receipt
```
GET /receipts/{id}/points
```

STEPS TO RUN:

```
git clone https://github.com/your-username/receipt-processor.git
cd receipt-processor
```
runs in http://localhost:8080
```
mvn clean install
```

```

mvn spring-boot:run

```
