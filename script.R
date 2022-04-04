# UAPS project 
source("https://fileadmin.cs.lth.se/cs/Education/EDAA35/R_resources.R") #vet ej om detta behövs


plotresult <- function(file,start = 1){
  data <- read.csv(file)
  data <- data[start:nrow(data),]
  plot(data, type='l')
}


listOfMeans10J <- c(1:5)
listOfMeans10C <- c(1:5)


#compile first java
for (i in 1:5) {
  system ("java -cp /Users/anna/Documents/uaps-project/sorters_java/src/uaps/Sort.java/bin /Users/anna/Documents/uaps-project/sorters_java/src/uaps/Sort.java /Users/anna/Documents/uaps-project/data.txt /Users/anna/Documents/uaps-project/output_java_test_R.txt 10")
  resultJ <- read.csv("/Users/anna/Documents/uaps-project/output_java_test_R.txt")
  meanJ <- mean(resultJ[,2])
  listOfMeans10J[i] <- meanJ
}


#compile first?
for (i in 1:5) {
  system("/Users/anna/Documents/uaps-project/sorters_c/sort.c /Users/anna/Documents/uaps-project/sorters_java/src/uaps/Sort.java /Users/anna/Documents/uaps-project/data.txt /Users/anna/Documents/uaps-project/sorters_java/src/uaps/Sort.java /Users/anna/Documents/uaps-project/data.txt /Users/anna/Documents/uaps-project/output_C_test_R.txt antal_körningar")
  resultC <- read.csv("/Users/anna/Documents/uaps-project/output_C_test_R.txt")
  meanC <- mean(resultC[,2])
  listOfMeansC[i] <- meanC
}

meanJ10 <- mean(listOfMeans10J)
confidenceInterval(listOfMeans10J,confidenceLevel =0.95)

meanC10 <- mean(listOfMeans10C)
confidenceInterval(listOfMeansC,confidenceLevel =0.95)


plotresult("/Users/anna/Documents/uaps-project/output_java_test_R.txt") # plot to screen
pdf("resultatfilenJ.pdf")
plotresult("resultJ.txt") # plot to pdf file
dev.off ()

plotresult("/Users/anna/Documents/uaps-project/output_C_test_R.txt") # plot to screen
pdf("/Users/anna/Documents/uaps-project/output_C_test_R.txt")
plotresult("/Users/anna/Documents/uaps-project/output_C_test_R.txt") # plot to pdf file
dev.off ()
