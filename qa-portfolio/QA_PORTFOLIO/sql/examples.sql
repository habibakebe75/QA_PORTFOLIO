
-- Top 10 active users by number of tracks played (example schema)
SELECT user_id, COUNT(*) AS plays
FROM play_events
WHERE event_date >= CURRENT_DATE - INTERVAL '30 days'
GROUP BY user_id
ORDER BY plays DESC
LIMIT 10;

-- Subscription health check
SELECT user_id, status, start_date, end_date
FROM subscriptions
WHERE status IN ('trial', 'active')
ORDER BY end_date ASC;

-- Duplicate tracks by title/artist detection (data quality)
SELECT title, artist, COUNT(*) AS dupes
FROM tracks
GROUP BY title, artist
HAVING COUNT(*) > 1;
