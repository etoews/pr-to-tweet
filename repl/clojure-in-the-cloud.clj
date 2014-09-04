;; Infix

(+ 2 3)

;; Functional

(defn add-7
  [x]
  (+ x 7))

(add-7 2)

(map add-7 [2 3])

;; Lambda

(map (fn [x] (+ x 7)) [2 3])

(map #(+ %1 7) [2 3])

(defmacro when
  "Evaluates test. If true, evaluates body."
  [test & body]
  (list 'if test (cons 'do body)))

(when true (+ 2 3))
