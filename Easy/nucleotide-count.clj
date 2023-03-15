(ns nucleotide-count)

(def valid {\A 0, \T 0, \C 0, \G 0})

(defn count-of-nucleotide-in-strand [nucleotide strand] ;; <- Arglist goes here
  ;; your code goes here
  (cond
    (= (count strand) 0) 0
    (contains? valid nucleotide) (count (filter #(= nucleotide %) (seq strand)))
    :else (throw (Exception. "Not valid"))))

(defn nucleotide-counts [strand] ;; <- Arglist goes here
  ;; your code goes here
  (into valid (frequencies strand)))


