# 🚀 SpringBoot-Powered-AI

SpringBoot-Powered-AI is a clean, lightweight Spring Boot application that integrates with **Spring AI's ChatModel** to provide an **AI-powered REST API**. Just send a message — and get a smart reply!

---

## 🧠 Features

- ✅ Built using **Spring Boot**
- 🤖 Integrated with **Spring AI (ChatModel)**
- 🔁 Simple REST endpoint: `POST /api/ai/chat`
- 🧩 Easily extendable for any AI-based use case

---

## ⚙️ Getting Started

### 📦 Prerequisites

- Java 17+
- Maven

### ▶️ Run the App

```bash
# 1. Clone the repo
git clone https://github.com/your-username/SpringBoot-Powered-AI.git
cd SpringBoot-Powered-AI

# 2. Run the Spring Boot application
./mvnw spring-boot:run
```
### API Endpoint
### POST /api/ai/chat
#### Request Body (JSON)
```
{
  "message": "Tell me a fun fact about Java"
}
```
#### Sample curl Request
```
curl -X POST http://localhost:8080/api/ai/chat \
  -H "Content-Type: application/json" \
  -d '{"message": "What is Spring Boot?"}'
```
