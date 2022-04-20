# UAPS project 
# Before running the script, compile both the Java and C files.
# Java: javac sorters_java/src/uaps/Sort.java -d out
# C: gcc -O3 sorters_c/sort.c -o sorters_c/a.out

source("https://fileadmin.cs.lth.se/cs/Education/EDAA35/R_resources.R") #needed for confidence interval


plotresult <- function(file){
  data <- read.csv(file)
  plot(data, type='l')
}


listOfMeansJava <- c(1:5)
listOfMeansC <- c(1:5)


for (i in 1:5) {
  system ("java -cp out uaps.Sort data.txt generated/output_java.txt 10")
  resultJ <- read.csv("generated/output_java.txt")
  meanJ <- mean(resultJ[,2])
  listOfMeansJava[i] <- meanJ
}


for (i in 1:5) {
  system("sorters_c/a.out data.txt generated/output_C.txt 10")
  resultC <- read.csv("generated/output_C.txt")
  meanC <- mean(resultC[,2])
  listOfMeansC[i] <- meanC
}

meanJ10 <- mean(listOfMeansJava)
confidenceInterval(listOfMeansJava,confidenceLevel =0.95)


meanC10 <- mean(listOfMeansC)
confidenceInterval(listOfMeansC,confidenceLevel =0.95)


plotresult("generated/output_java.txt") # plot to screen
pdf("generated/resultJava.pdf")
plotresult("generated/output_java.txt") # plot to pdf file
dev.off()


plotresult("generated/output_C.txt") # plot to screen
pdf("generated/resultC.pdf")
plotresult("generated/output_C.txt") # plot to pdf file
dev.off()
