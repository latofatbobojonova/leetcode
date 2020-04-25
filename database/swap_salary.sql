UPDATE salary
SET sex =
        CASE
            WHEN sex = 'm' THEN 'f'
            WHEN sex = 'f' THEN 'm'
            END
WHERE sex IN ('m', 'f');

UPDATE salary
SET sex =
        CASE
            WHEN sex = 'm' THEN 'f'
            ELSE 'm'
            END;

