/
├── docs   
│   └── alibek.pdf                 
├── src   
│   ├── main  
│   │   └── java  
│   │       ├── algorithms  
│   │       │   └── MaxHeap.java  
│   │       ├── cli  
│   │       │   └── BenchmarkRunner.java   
│   │       └── metrics                    
│   └── test  
│       └── java  
│           └── algorithms  
│               └── MaxHeapTest.java        
├── pom.xml  
├── .gitignore  
└── README.md   

Clone the repository:
git clone https://github.com/nurzhan1206/DAA2.git
Navigate to the project directory:
cd DAA2
Build the project:
mvn clean install
Run unit tests:
mvn test
Run benchmark analysis:
mvn exec:java -Dexec.mainClass="cli.BenchmarkRunner"


Implemented Components
 MaxHeap.java

Implements a max binary heap with standard operations:

insert() — adds a new element

extractMax() — removes and returns the maximum element

heapify() — restores the heap property

buildHeap() — builds a heap from an unsorted array

All operations are optimized to run in O(log n) in the worst case.

 BenchmarkRunner.java

A command-line utility that measures the execution time of heap operations for various input sizes.
It’s used to analyze performance and verify logarithmic complexity in practice.

 MaxHeapTest.java

Unit tests implemented using JUnit.
They verify:

Correctness of insertion and extraction

Proper heap structure after each operation

Handling of edge cases (empty heap, single element, etc.)

\Results and Analysis

All tests passed successfully, confirming the correctness of the MaxHeap implementation.
Benchmark experiments show that the running time of key operations grows logarithmically with input size, which matches the expected theoretical complexity of O(log n).

Possible Improvements

Add visualization of heap structure

Implement MinHeap for comparison

Include memory usage analysis (space complexity)

Add CLI input options for BenchmarkRunner
