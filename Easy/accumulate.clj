(ns accumulate)

(defn accumulate [func arg]
  (if (empty? arg) []
      (cons (func (first arg)) (accumulate func (rest arg)))))
