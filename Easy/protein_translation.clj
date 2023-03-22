(ns protein-translation)

(defn test-protein [data]
  (case data
    ("AUG") "Methionine"
    ("UUU" "UUC") "Phenylalanine"
    ("UUA", "UUG") "Leucine"
    ("UCU", "UCC", "UCA", "UCG") "Serine"
    ("UAU", "UAC") "Tyrosine"
    ("UGU", "UGC") "Cysteine"
    ("UGG") "Tryptophan"
    ("UAA", "UAG", "UGA") "STOP"))

(defn translate-codon [data] ;; <- arglist goes here
      ;; your code goes here
  (test-protein data))

(defn translate-rna [data] ;; <- arglist goes here
  ;; your code goes here
  (->> (re-seq  #".{3}" data)
       (map test-protein)
       (take-while #(not= % "STOP"))))
