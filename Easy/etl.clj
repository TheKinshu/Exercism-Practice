(ns etl (:require [clojure.string :as string]))

(defn transform [source] ;; <- arglist goes here
  ;; your code goes here
  (into {} (for [ky (keys source) val (source ky)]
             [(string/lower-case val) ky])))

(transform {1 "World"})


(= {"world" 1} (etl/transform {1 ["WORLD"]}))