# Multiprocessing and Multithreading in Java

## 📌 Overview

This project demonstrates the implementation and comparison of **Multithreading** and **Multiprocessing** concepts using Java. It analyzes the performance of both techniques by executing CPU-intensive tasks and comparing their execution time and memory usage.

This project was developed as part of the **Operating Systems Laboratory** coursework.

---

## 🎯 Objectives

- Understand the concepts of multithreading and multiprocessing.
- Implement concurrent execution using Java threads.
- Simulate multiprocessing using Java's `ProcessBuilder`.
- Compare execution time and memory usage.
- Analyze the advantages and limitations of both approaches.

---

## 🛠 Technologies Used

- Java (JDK 17 or above)
- Visual Studio Code
- Java Extension Pack
- ProcessBuilder API
- Thread Class

---

## 📂 Project Structure

```
OS-Java-Project/
│
├── MultiThreading.java
├── MultiProcessing.java
├── Worker.java
├── README.md
└── Report.pdf
```

---

## ⚙️ How It Works

### Multithreading
- Creates multiple threads within a single Java process.
- All threads share the same memory space.
- Suitable for lightweight concurrent execution.

### Multiprocessing
- Creates multiple independent Java processes using `ProcessBuilder`.
- Each process has its own memory space.
- Suitable for CPU-intensive tasks.

---

## 🚀 Compilation

Compile all Java files:

```bash
javac *.java
```

Or compile individually:

```bash
javac Worker.java
javac MultiThreading.java
javac MultiProcessing.java
```

---

## ▶️ Running the Programs

### Multithreading

```bash
java MultiThreading
```

Sample Input

```
Enter number of threads: 4
Enter workload: 50000000
```

---

### Multiprocessing

```bash
java MultiProcessing
```

Sample Input

```
Enter number of processes: 4
Enter workload: 50000000
```

---

## 📊 Sample Output

### Multithreading

```
Multithreading Completed

Execution Time: 185 ms
Memory Usage: 1240 KB
```

### Multiprocessing

```
Multiprocessing Completed

Execution Time: 120 ms
Memory Usage: 1325 KB
```

---

## 📈 Comparison

| Feature | Multithreading | Multiprocessing |
|----------|----------------|-----------------|
| Execution Model | Multiple Threads | Multiple Processes |
| Memory Usage | Lower | Higher |
| Memory Space | Shared | Separate |
| Communication | Fast | Slower |
| CPU Utilization | Moderate | High |
| Best Suitable For | I/O-bound Tasks | CPU-bound Tasks |

---

## ✅ Advantages

### Multithreading
- Faster communication between threads.
- Low memory consumption.
- Efficient resource sharing.
- Lightweight execution.

### Multiprocessing
- True parallel execution.
- Better CPU utilization.
- Improved fault isolation.
- Suitable for computationally intensive tasks.

---

## 📚 Learning Outcomes

Through this project, we gained practical knowledge of:

- Java concurrency using threads.
- Process creation using `ProcessBuilder`.
- Measuring execution time.
- Memory utilization analysis.
- Performance comparison between multithreading and multiprocessing.


## 📄 License

This project is developed solely for educational and academic purposes as part of the Operating Systems Laboratory.
