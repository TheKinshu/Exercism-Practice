(ns complex-numbers)

(defn real [[a b]] ;; <- arglist goes here
  a)

(defn imaginary [[a b]] ;; <- arglist goes here
  b)

(defn abs [[a b]] ;; <- arglist goes here
  (Math/sqrt (+ (* a a) (* b b))))
(defn conjugate [[a b]] ;; <- arglist goes here
  [a (- b)])

(defn add [[a b] [c d]] ;; <- arglist goes here
  [(+ a c) (+ b d)])

(defn sub [[a b] [c d]] ;; <- arglist goes here
  ;; your code goes here
  [(- a c) (- b d)])

(defn mul [[a b] [c d]] ;; <- arglist goes here
  ;; your code goes here
  [(- (* a c)
      (* b d))
   (+ (* b c)
      (* a d))])

(defn div [[a b] [c d]] ;; <- arglist goes here
  ;; your code goes here
  [;; (a * c + b * d)/(c^2 + d^2)
   (->> (+ (* c c) (* d d))
        (/ (+ (* a c) (* b d)))
        (double))
   ;; (b * c - a * d)/(c^2 + d^2)
   (->> (+ (* c c) (* d d))
        (/ (- (* b c) (* a d)))
        (double))])
