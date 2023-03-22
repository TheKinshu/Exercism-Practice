(ns roman-numerals)

(def roman-list
  (sort-by val >
           {\I   1   \V   5   \X   10   \L   50
            \C   100 \D   500 \M   1000 "IV" 4
            "IX" 9   "XL" 40  "XC" 90   "CD" 400
            "CM" 900}))

(defn numerals [num]
  (loop [letter "" n num]
    (if (zero? n) letter
        (let [[keys vals] (some #(when (<= (val %) n) %) roman-list)]
          (recur (str letter keys) (- n vals))))))

(numerals 3222)