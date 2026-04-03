# 🛒 Product Management API

REST API untuk mengelola data produk menggunakan Spring Boot dan MySQL.  
Project ini dibuat sebagai bagian dari portfolio Back End Development untuk menunjukkan kemampuan dalam membangun API yang terstruktur, scalable, dan mudah digunakan.

---

## 📌 Overview

API ini memungkinkan admin untuk:
- Menambahkan produk baru
- Mengedit data produk
- Memperbarui stok saat terjadi penjualan
- Menghapus produk

Sistem ini dirancang untuk membantu proses manajemen produk menjadi lebih efisien dan mengurangi kesalahan input data.

---

## ⚙️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Postman (testing)

---

## 🧱 Project Structure
src
└── main
└── java
└── com.example.productapi
├── controller
├── service
├── repository
├── entity
├── dto
└── exception

---

## 🔌 API Endpoints

### 1. Add Product
POST /products
Request:
json:
{
  "name": "Laptop",
  "price": 1000,
  "description": "Gaming Laptop",
  "stock": 10
}

2. Edit Product
   PUT /products/{id}

3. Update Stock
   PATCH /products/{id}/stock?soldQty=2

4. Delete Product
   DELETE /products/{id}

✅ Validation Rules
name → wajib diisi
price → harus lebih dari 0
stock → minimal 0
description → optional

🚨 Error Handling
API menggunakan Global Exception Handler untuk menghasilkan response yang konsisten:
Contoh Error 400
{
  "status": 400,
  "error": "BAD_REQUEST",
  "message": "Price harus lebih dari 0"
}

Contoh Error 500
{
  "status": 500,
  "error": "INTERNAL_SERVER_ERROR",
  "message": "Unexpected error"
}

🗄️ Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/product_db?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=yourpassword

🧪 Testing
API diuji menggunakan Postman dengan berbagai skenario:
- Success case
- Validation error
- Business logic error (stock habis, dll)
- Internal server error

🚀 How to Run
- Clone repository
git clone https://github.com/username/product-api.git
- Buka di IntelliJ
Jalankan aplikasi:
Run ProductApiApplication
- Test API di Postman:
http://localhost:8080/products

🎯 Key Learnings
- Implementasi REST API menggunakan Spring Boot
- Validasi input menggunakan annotation
- Error handling dengan @RestControllerAdvice
- Integrasi database menggunakan JPA
- Struktur project backend yang clean

📈 Future Improvements
- Tambah authentication (JWT)
- Pagination & filtering
- Logging & monitoring
- Deploy ke cloud
