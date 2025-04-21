# 🚢 PickSpot API

A simple Spring Boot project that selects an appropriate yard slot for a shipping container based on its size and cold-storage needs.

---

## 📦 Features

- Accepts container details and yard map via a POST request
- Filters and selects the most appropriate available slot
- Returns the selected slot position or an error if no slot is found
- Built using:
    - Spring Boot
    - Functional Endpoints (`RouterFunction`)
    - Gson for JSON processing
    - Lombok for cleaner model classes

---

## 🛠 Tech Stack

- Java 17+
- Spring Boot 3+
- Gson
- Lombok
- Maven

---

## 🔧 How to Run

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-username/pickspot-api.git
   cd pickspot-api

2. **Build the project**

   ```bash
   ./mvnw clean install
   ```
3. **Run the application**

   ```bash
    ./mvnw spring-boot:run
    ```
4. **Test the API**

   You can use tools like Postman or curl to test the API.

   ### ✅ Case 1: Successful Slot Allocation

   ```json
   {
       "container": {
        "id": "C002",
        "size": "LARGE",
       "needsCold": true
    },
     "yardMap": [
       { "x": 0, "y": 0, "sizeCap": "SMALL", "occupied": false, "hasColdUnit": false },
       { "x": 1, "y": 0, "sizeCap": "MEDIUM", "occupied": true, "hasColdUnit": true },
       { "x": 2, "y": 1, "sizeCap": "LARGE", "occupied": true, "hasColdUnit": true },
       { "x": 3, "y": 2, "sizeCap": "LARGE", "occupied": false, "hasColdUnit": false }
    ]
   }
   ```
    ### Output:
    
    ```json
    {
       "containerId": "C1",
       "targetX": 1,
       "targetY": 2
    }
    ```
   ### ❌ Case 2: No Suitable Slot Found
     
   ```json
   {
          "container": {
          "id": "C002",
          "size": "LARGE",
          "needsCold": true
             },
         "yardMap": [
               { "x": 0, "y": 0, "sizeCap": "SMALL", "occupied": false, "hasColdUnit": false },
               { "x": 1, "y": 0, "sizeCap": "MEDIUM", "occupied": true, "hasColdUnit": true },
               { "x": 2, "y": 1, "sizeCap": "LARGE", "occupied": true, "hasColdUnit": true },
               { "x": 3, "y": 2, "sizeCap": "LARGE", "occupied": false, "hasColdUnit": false }
              ]
   }
      ```
    ### Output:
   ```json
    {
    "error": "No suitable slot found"
    }
    ```



   
