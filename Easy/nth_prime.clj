(ns nth-prime)

(defn nth-prime
  "Returns the prime number in the nth position."
  [n] ;; <- arglist goes here
  ;; your code goes here
  )


(filter (rem (iterate inc 2) %))


(defn prime? [n]
  (loop [divisor 2]
    (cond (> (* divisor divisor) n) true
          (zero? (rem n divisor)) false
          :else (recur (inc divisor)))))

(prime? 3)

(defn nth-prime [n]
  (let [primes (take n (iterate (fn [[p & ps]] (first (drop-while #(or (zero? (rem p %)) (< % (* 2 p))) (cons p ps)))) [2]))]
    (last primes)))

(nth-prime 10)

(defn is-prime? [n]
  (cond
    (< n 2) false       ; 0 and 1 are not prime
    (= n 2) true        ; 2 is the only even prime number
    (even? n) false     ; all other even numbers are not prime
    :else               ; check odd numbers up to the square root of n
    (not-any? #(zero? (mod n %)) (range 3 (inc (Math/sqrt n))) 2)))

(is-prime? 2)

(defn something [n]
  (let [x (* 1 4)]
    (cond
      (= x 4) true
      :else false)))

(or (= 1 2) (> 3 10))