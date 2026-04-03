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
<p>src</p>
<p>└── main</p>
<p>└── java</p>
<p>└── com.example.productapi</p>
<p>├── controller</p>
<p>├── service</p>
<p>├── repository</p>
<p>├── entity</p>
<p>├── dto</p>
<p>└── exception</p>

---

## 🔌 API Endpoints

 1. Add Product
<p>POST /products</p>
<p>json:</p>
<p>{
  "name": "Laptop",
  "price": 1000,
  "description": "Gaming Laptop",
  "stock": 10
}</p>

2. Edit Product
   <p>PUT /products/{id}</p>

3. Update Stock
   <p>PATCH /products/{id}/stock?soldQty=2</p>

4. Delete Product
   <p>DELETE /products/{id}</p>

---

✅ Validation Rules
<p>name → wajib diisi</p>
<p>price → harus lebih dari 0</p>
<p>stock → minimal 0</p>
<p>description → optional</p>

---

🚨 Error Handling
<p>API menggunakan Global Exception Handler untuk menghasilkan response yang konsisten:</p>
Contoh Error 400
<p>
{
  "status": 400,
  "error": "BAD_REQUEST",
  "message": "Price harus lebih dari 0"
}
</p>

Contoh Error 500
<p>
{
  "status": 500,
  "error": "INTERNAL_SERVER_ERROR",
  "message": "Unexpected error"
}
</p>

---

🗄️ Database Configuration

<p>spring.datasource.url=jdbc:mysql://localhost:3306/product_db?useSSL=false&allowPublicKeyRetrieval=true</p>
<p>spring.datasource.username=root</p>
<p>spring.datasource.password=yourpassword</p>

---

🧪 Testing
API diuji menggunakan Postman dengan berbagai skenario:
- Success case
- Validation error
- Business logic error (stock habis, dll)
- Internal server error

---

🚀 How to Run
- Clone repository
git clone https://github.com/username/product-api.git
- Buka di IntelliJ
Jalankan aplikasi:
Run ProductApiApplication
- Test API di Postman:
http://localhost:8080/products

---

🎯 Key Learnings
- Implementasi REST API menggunakan Spring Boot
- Validasi input menggunakan annotation
- Error handling dengan @RestControllerAdvice
- Integrasi database menggunakan JPA
- Struktur project backend yang clean

---

📈 Future Improvements
- Tambah authentication (JWT)
- Pagination & filtering
- Logging & monitoring
- Deploy ke cloud
