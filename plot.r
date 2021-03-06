library(car)

d <- read.csv("~/Documents/io/mirango/mst/max-edge-mst.txt")

ls <- loess(y ~ x, data=d)
pr.loess <- predict(ls)
m <-lm(y ~ x, data=d)
abline(coef(m), col="blue")
pr.abline <- predict(m)

fit1 <- lm(y~poly(x,5,raw=TRUE), data=d)

plot(y ~ x, data=d, xlab="vertices", ylab="largest edge in mst", main="Largest Edge by Number of Vertices")
lines(pr.loess~x, data=d, col="red", lwd=2)
lines(pr.abline~x, data=d, col="blue", lwd=2)

xx <- seq(0,3000, length=100)
lines(xx, predict(fit1, data.frame(x=xx)), col="green", lwd=2)

summary(pr.abline)
summary(pr.loess)
summary(fit1)
