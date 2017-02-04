library(car)

d <- read.csv("~/Documents/io/mirango/mst/max-edge-mst.txt")

scatterplot(y ~ x, data = d, xlab="number of vertices", ylab="largest edge in mst", main="Largest Edge by # of Vertices", labels=row.names(d), reg.line=TRUE)

fit <- lm(y ~ x, data=d)
summary(fit)