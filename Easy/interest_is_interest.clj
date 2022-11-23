(ns interest-is-interesting)

(defn interest-rate
  "TODO: add docstring"
  [balance]
  (cond
    (< balance 0) -3.213
    (< balance 1000) 0.5
    (and (< balance 5000) (> balance 999)) 1.621
    (> balance 4999) 2.475))

(defn annual-balance-update
  "TODO: add docstring"
  [balance]
  (let [x (/ (interest-rate balance) 100)
        y (bigdec balance)]
    (cond
      (= y 0.0M) 0.0M
      (> y 0.0M) (* y (bigdec (+ 1 x)))
      (< y 0.0M) (* y (bigdec (- 1 x))))))

(defn amount-to-donate
  "TODO: add docstring"
  [balance tax-free-percentage]
  (cond
    (> balance 0.0M) (int (* 2 (/ (* balance tax-free-percentage) 100)))
    (< balance 0.0M) 0
    (= (bigdec balance) 0.0M) 0))